# pre codereview

- return Optional - dobra rzecz
- tylko kontrolery http, bez logiki, która powinna być wydelegowana do serwisu
- `@ExceptionHandler` ze springboot
- post mapping not static, don't hardcode URI w `URI.create` (path) - use server context or something like that
