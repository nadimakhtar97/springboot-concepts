# JSON WEB TOKEN (JWT)



## HTTP IS A STATELESS PROTOCOL

Every interaction in HTTP need to contain all the information needed for that interaction.
Nothing is remembered from before no state is maintained over like multiple request.

When server is application is static and available to everyone then there in no problem.
Because you don't need to send information about yourself to tell server who you are
because the static application is available to every one.

![image](https://drive.google.com/uc?id=1toCKXDXGQNt9HaFIjWFhOsXNgBZ_JQWa)


The problem happens when response from the server is dynamic and, it depends upon who the
user is. In this case the information you need to send to the server is not just what page you want but
also who you are.

![image](https://drive.google.com/uc?id=15vyt5HC2pqgHkhN2baxp1eXB8sLxu2jH)

1. ![image](https://drive.google.com/uc?id=17MyKq4kH0afBycXueOiMuMwAgTYmUmMl)
2. ![image](https://drive.google.com/uc?id=18EUtqTk0gzPaOQYLZLdGp6swCc-w7ZeK)
3. ![image](https://drive.google.com/uc?id=1e4lDJUhRUY-MaeBo2zBWQL-WtwP6uC2I)
4. ![image](https://drive.google.com/uc?id=1w01lIr_WQN0HO0b8Ar5kjkxkHzImKbcQ)
5. ![image](https://drive.google.com/uc?id=1AMB17xjQUlGxfdfVeq7JjvQOF6xq4OvT)
6. ![image](https://drive.google.com/uc?id=1SzMK6XXUZR3Qts9X9ItjeyzoTAcGfHuz)

The above case does not happen in modern web apps. Web apps do not ask for
authentication on each request rather they know before-hand who you are. We
use authorization strategies to solve this kind of problems.


## There are two major authorization/authentication strategies

1. Session Token
2. JSON web token

![image](https://drive.google.com/uc?id=1uq26VOs6kvMrftwKciKGVDo4HtgwdU9N)

## Session ID + Cookies (Most popular mechanism for authorization)

1. ![image](https://drive.google.com/uc?id=16bzS1r3htncNp2yHqcRcwJdTvzMGWSE8)
2. ![image](https://drive.google.com/uc?id=1g2zS5yk_EvwrQIJOCfvuhH_mLKawGJDg)

Limitation of Session ID + Cookies Method
*****
1. It assumes that there is only one monolithic server web application
2. Rather moder web app look like this
3. ![image](https://drive.google.com/uc?id=13lFbWtlpB4o2vROanMhEFDITxn2z4v4u)
4. The major problem with above approach is that load balancer may redirect the request
to a server which does not contain Session ID of the user.
5. The solution to this would be
6. ![image](https://drive.google.com/uc?id=1a3C3q72x8u3mrssG8FumAHuyAcu_D50X)
7. The above approach also has single point of failure.


## JWT

Upon request for authentication, server sends back a signed jwt token which contains all
the information to the user which is required to make subsequent requests.

Server signs the jwt token because no other can just copy the jwt token and make request
on behalf of user.

1. ![image](https://drive.google.com/uc?id=1uxKloITzQcOTC5BvbqwAAk_JKgTtCuIX)
2. ![image](https://drive.google.com/uc?id=17B6CG_k2VuuLirtIfsQjoni_iMPYmZCE)
3. ![image](https://drive.google.com/uc?id=1CA8TiVZ8rYRUBhAWvCMFauVf3P4IQt0d)
4. ![image](https://drive.google.com/uc?id=1y2f4qr_SqprAw5HNqcacT06TvVXLTGFl)
5. ![IMAGE](https://drive.google.com/uc?id=1tMI1ZIdqWmQNg90nC5OA9wWhWypPu25X)

## STRUCTURE OF JWT

![image](https://drive.google.com/uc?id=1JPKdfidAK4P8sCQ3AWEMKH5YMubTwna4)
![image](https://drive.google.com/uc?id=1zqclJkxhdXFbwzfWeXf7YPped8t2vYn0)