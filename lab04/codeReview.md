# pre codereview

- return Optional - dobra rzecz
- tylko kontrolery http, bez logiki, która powinna być wydelegowana do serwisu
- `@ExceptionHandler` ze springboot
- post mapping not static, don't hardcode URI w `URI.create` (path) - use server context or something like that

# lab05

- ofNullable(id) to think about
- get edit, podczas edycji obiektu, którego już nie ma - redirect niż error, bo inaczej jest whitelabel error page (wielodostępność)
