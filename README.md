# Lift SameSite Cookie workaround

## What ?

This is a sample project on how to add the SameSite value to HTTP cookies using Lift as an alternative until SameSite is officially supported at Lift and/or Servlet level.

## Why ?

Because the major browsers sets the usage of SameSite as required nowadays for enforcing better security and if you want to call API along your Lift application you will need something to make SameSite cookies to work, even as a workaround.

## How ?

Cookies are no more than text based headers, so in this sample workaround we are just using Netty to encode the cookie (including SameSite) as a string and then added as a "Set-Cookie" standard header

Please review the recent commits to check how it's done using Lift base cookies and how to then use them with Netty for leveraging the SameSite cookies.

## Guide

1. Clone this repo
2. Install and run `sbt`
3. Execute `jetty:quickstart` inside SBT
4. Go to `http://localhost:8080` with your favorite browser
5. Click on the `Set Cookie` menu item to add a cookie value
6. Click on the `Read Cookie` to check the cookie value is correctly read

NOTE: At source code level please start at `CookieSnippet.scala`
