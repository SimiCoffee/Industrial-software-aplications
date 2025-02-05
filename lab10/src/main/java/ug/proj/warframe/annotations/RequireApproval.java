package ug.proj.warframe.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Adnotacja wymuszająca potwierdzenie operacji (np. usunięcia danych).
 */
// @Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequireApproval {
}
