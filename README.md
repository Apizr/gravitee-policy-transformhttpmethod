# Http-Method-Transform Gravitee Policy

This policy allow API publisher to change the HTTP method before redirect to the endpoint.

Example :

| Host     | HTTP method                 |
| -------- | --------------------------- |
| Client   | GET                         |
| Gateway  | GET -> POST (transformation)|
| Endpoint | POST                        |

