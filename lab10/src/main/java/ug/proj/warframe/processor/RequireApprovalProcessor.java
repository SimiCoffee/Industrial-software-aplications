package ug.proj.warframe.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;

@AutoService(Processor.class)
@SupportedAnnotationTypes("ug.proj.warframe.annotations.RequireApproval")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class RequireApprovalProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("🚀 Procesor RequireApproval działa!");
		for (Element element : roundEnv
				.getElementsAnnotatedWith(ug.proj.warframe.annotations.RequireApproval.class)) {
			System.out.println("📌 Przetwarzanie: " + element.getSimpleName());
			if (element.getKind() == ElementKind.METHOD) {
				ExecutableElement method = (ExecutableElement) element;
				String className = ((TypeElement) method.getEnclosingElement()).getQualifiedName()
						.toString();
				String methodName = method.getSimpleName().toString();

				try {
					generateApprovalWrapper(className, methodName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	private void generateApprovalWrapper(String className, String methodName) throws IOException {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
				"Processing: " + className + "." + methodName);
		String generatedClassName = className + "_ApprovalWrapper";
		JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(generatedClassName);

		try (Writer writer = builderFile.openWriter()) {
			writer.write("package " + className.substring(0, className.lastIndexOf('.')) + ";\n");
			writer.write("import org.springframework.http.HttpHeaders;\n");
			writer.write("import org.springframework.http.HttpStatus;\n");
			writer.write("import org.springframework.http.ResponseEntity;\n");
			writer.write("import org.springframework.web.bind.annotation.RequestHeader;\n");
			writer.write("public class " + generatedClassName + " {\n");
			writer.write("    public static ResponseEntity<String> " + methodName
					+ "(HttpHeaders headers, Long id) {\n");
			writer.write("        if (!headers.containsKey(\"X-Approval\") || !\"true\".equals(headers.getFirst(\"X-Approval\"))) {\n");
			writer.write("            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(\"Operacja wymaga potwierdzenia przez nagłówek X-Approval: true\");\n");
			writer.write("        }\n");
			writer.write("        return " + className + "." + methodName + "(id);\n");
			writer.write("    }\n");
			writer.write("}\n");
		}
	}
}
