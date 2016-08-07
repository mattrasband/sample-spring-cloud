# Spring Cloud

This is an example project combining many features of the Spring Cloud ecosystem (including Netflix OSS features):

* Eureka: Service Discovery
* Zuul: API Gateway (:8080) - All requests should go through here
* OAuth2 Provider: Supports password grant, the intended use here
* Some OAuth2 Service: "resource"
* Config Server: TODO

The only port you should need to know is the api gateway, as the rest of the apps automatically register their url with the api gateway. Instead, you can access the resources via their "name" through the API Gateway:  `localhost:8080/<app_name>/<app_path>`

You can login with (user/password or admin/admin123):

    curl -X POST localhost:8080/auth/oauth/token \
        -d 'grant_type=password&username=user&password=password&client_id=myClient' \
        -u myClient:secret

Use the `access_token` to access the resource service:

    curl localhost:8080/resource/foo \
        -H 'Authorization: Bearer $ACCESS_TOKEN'

This allows any authenticated user, but, as an example, the "write" method is protected by authorities:

    curl localhost:8080/resource/foo \
        -H 'Authorization: Bearer $ACCESS_TOKEN' \
        -X POST

It requires that you are the admin user, otherwise you will get a 403.