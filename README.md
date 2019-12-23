# social-login-example
The scope of this project is to delegate the authentication to 3rd party providers, Google and Facebook, then exchange the jwt received for an internal access token. 

The scopes received from authentication server will not be taken into account. Google/Facebook will be used just to authenticate the user, not to authorize it into our application

So basicaly there are 4 steps:
1. request an authorization code from a provider
2. exchange the authorization code for a jwt
3. exchange the jwt for an access token (Resource Owner Password Grant flow)
4. access the protectet resources using the access token from step 3

In order to try the Facebook and Google adapters, you'll need to obtain an access token from these services. 
User below steps for each provider: 
- Google: 
    - https://console.developers.google.com
        - from Credentials->Create credential->OAuth client ID
            - please note down the Client ID, Client Secret and Authorized redirect URIs (for this project you can add whatever you want as URI)
- Facebook:
    - https://developers.facebook.com</br>
        - My apps->create new app</br>
            - chose Facebook Login as product</br>
                - please note down the Client ID, Client Secret and Authorized redirect URIs (for this project you can add whatever you want as URI, as long as it is a https) </br>
- LinkedIn:
    - https://docs.microsoft.com/en-us/linkedin/shared/authentication/authorization-code-flow?context=linkedin/context
        - create a new company page
        - create a new app and associate it with the page
        - please note down the client id, the client secret and set a redirect URI 


Once you have apps to log in to, you can use the requests from the Postman collection to first obtain your token, then test it against the social-login implementation.

### For Google:
- from Chrome, or another browser, run the first request
- the Google login screen will appear. Log in.
- you'll be forwarded to your redirect_uri
<code>http://localhost:1234/?code=code+value+here&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=82ceaa62f3ead8c1e9f6bc8503f0b275f2ab2fcb..3e4a&prompt=consent#</code>
- copy the received code and exchange it for an access code, by running the Google API Auth Code request
- all steps until here are normally handled by the client API. Copy the id_token and pass it to the social flow, by using OAuth Token Google

### For Facebook:
- from Chrome, or another browser, run the first request
- the Facebook login screen will appear. Log in.
- you'll be forwarded to your redirect_uri
<code>https://localhost:8443/?#access_token=token+is+here&data_access_expiration_time=1580299043&expires_in=3756&state=123</code>
- all steps until here are normally handled by the client API. Copy the access_token and pass it to the social flow, by using OAuth Token Facebook

### For LinkedIn:
- from Chrome, or another browser, run the first request
- the LinkedIn login screen will appear. Log in.
- you'll be forwarded to your redirect_uri
<code>http://localhost:1234/?code=token+is+here&state=fooobar</code>
- all steps until here are normally handled by the client API. Copy the code and pass it to the social flow, by using OAuth Token LinkedIn