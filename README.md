
# SpringBoot Rest API Starter

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Build Status](https://travis-ci.com/spinsage/springboot-starter-restapi.svg?branch=main)](https://travis-ci.com/spinsage/springboot-starter-restapi)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/503386f7e4f14a14b65fb3bd603b9c34)](https://app.codacy.com/gh/spinsage/springboot-starter-restapi?utm_source=github.com&utm_medium=referral&utm_content=spinsage/springboot-starter-restapi&utm_campaign=Badge_Grade)
[![Black Duck Security Risk](https://copilot.blackducksoftware.com/github/repos/spinsage/springboot-starter-restapi/branches/main/badge-risk.svg)](https://copilot.blackducksoftware.com/github/repos/spinsage/springboot-starter-restapi/branches/main)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/spinsage/springboot-starter-restapi.svg)](http://isitmaintained.com/project/spinsage/springboot-starter-restapi "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/spinsage/springboot-starter-restapi.svg)](http://isitmaintained.com/project/spinsage/springboot-starter-restapi "Percentage of issues still open")

Boilerplate maven project for bootstrapping development of a Rest API application using SpringBoot.


## Getting Started

### Build the application

- Clone the repository.
- Execute the maven command.

	```bash
	mvn clean package
	```
### Run the application

#### Within a Docker container

- Create a .env file by copying .env.sample.
- Update environment variable values in the .env file as needed.
- Execute docker-compose

	```console
	docker-compose up
	```

#### As a standalone application

```console
cd target
java -jar springrest-0.0.1-SNAPSHOT.jar
```

## LICENSE

**SpringBoot Rest API Starter** is Apache 2.0 licensed.

## Let us know!

We at [**Spinsage**](https://www.spinsage.com/) would be happy if you send us links to your projects where you are using our code. Just send us an email at [opensource@spinsage.com](mailto:opensource@spinsage.com). 

And do let us know if you have any queries or suggestions regarding our work.
