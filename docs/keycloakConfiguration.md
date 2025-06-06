# Configuration de keycloak
## Docker
Creer un container keycloak et postgres comme suit :

```yaml
services:
  keycloak:
    image: quay.io/keycloak/keycloak:26.2.4
    container_name: keycloak-auth-container
    environment:
      KC_HTTP_PORT: 9000
      KEYCLOAK_ADMIN: ${KEYCLOAK_USER}
      KEYCLOAK_ADMIN_PASSWORD: ${KEYCLOAK_PASSWORD}
      KC_HOSTNAME: ${KEYCLOAK_URL}
      KC_DB_URL: jdbc:postgresql://keycloak_postgres:5432/keycloak
      KC_DB: postgres
      KC_DB_USERNAME: ${POSTGRES_USER}
      KC_DB_PASSWORD: ${POSTGRES_PASSWORD}
      KC_HTTP_ENABLED: 'true'
      KC_HOSTNAME_STRICT: 'false'
    command: start
    ports:
      - "9000:9000"
    networks:
      - sso-network
      - keycloak-network
    depends_on:
      - keycloak_postgres
  keycloak_postgres:
    container_name: keycloak_postgres
    image: postgres:latest
    restart: always
    environment:
      POSTGRES_DB: keycloak
      POSTGRES_USER: ${POSTGRES_USER}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_PORT: 5432
    volumes:
      - keycloak-postgres:/var/lib/postgresql/data
    networks:
      - keycloak-network
```

creez un .env comme suit
```
KEYCLOAK_USER=admin
KEYCLOAK_PASSWORD=123
KEYCLOAK_URL=localhost
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgrespassword
```
## Config keycloak

Sur [l'interface d'administration keycloak](http://localhost:9000/admin/master/console/#/master/realms)

- Ajoutez un Realm avec le nom de votre choix

- Ensuite, creez un utilisateur dans le realm via cette page http://localhost:9000/admin/master/console/#/realm_name/users

- Ensuite, creez un client depuis cette page http://localhost:9000/admin/master/console/#/realm_name/clients
  - Choisisez un type OpenID
  - Definissez un client ID de votre choix
  - Cliquez sur next
  - Activez la client authentication et le Direct access grants
  - Desactivez le Standard flow   
  - Cliquez sur next
  - Cliquez sur next
  - Allez dans Credentials et copier le secret.

## Test
Pour obtenir un bearer, effecter une requete comme celle qui suit
```sh
curl --request POST \
    --url http://localhost:9000/realms/realm_name/protocol/openid-connect/token \
    --header 'content-type: application/x-www-form-urlencoded' \
    --data client_id=id \
    --data client_secret=secret \
    --data grant_type=password \
    --data username=username \
    --data password=password \
    --data scope=openid
```

Vous devrez avoir une reponse comme celle ci
```
{
    "access_token": "...",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "...",
    "token_type": "Bearer",
    "id_token": "...",
    "not-before-policy": 0,
    "session_state": "c829f4b3-1078-46ef-820b-ef3da3496c81",
    "scope": "openid profile email"
}
```

Recupere le access_token de cette reponse et utilisez le pour la requete de verification d'id
```sh
curl --request GET \
    --url http://localhost:9000/realms/realm_name/protocol/openid-connect/userinfo \
    --header 'Authorization: Bearer eyJh...Po-_A'
```

Vous devez recevoir une reponse comme suit :

```json
{
    "sub": "7e0eede6-dafd-4a7b-a605-6f0aca654db6",
    "email_verified": false,
    "name": "Guillaume Aubert",
    "preferred_username": "gaubert",
    "given_name": "Guillaume",
    "family_name": "Aubert",
    "email": "xxx@xxx.xx"
}
```