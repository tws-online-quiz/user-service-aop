package user

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('should get a exist user')
            request {
                method GET()
                url ('/api/v1/users/1') {
                }
            }
            response {
                status(200)
                headers {
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body """
                    {
                        "data": {
                            "id": 1,
                            "attributes": {
                                "contacts": "/api/v1/users/1/contacts",
                                "roles": [
                                    {
                                        "name": "经理"
                                    }
                                ], 
                                "name": "张三"
                            }
                        }
                    }
                """
            }
        },

        Contract.make {
            name('should get a exist user owned contacts')
            request {
                method GET()
                url ('/api/v1/users/1/contacts') {
                }
            }
            response {
                status(200)
                headers {
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body """
                    {
                        "data": {
                            "id": 1,
                            "attributes": [
                                {
                                    "name": "张三",
                                    "province": "北京市",
                                    "city": "北京",
                                    "area": "东城区",
                                    "street": "东直门内大街",
                                    "more_details": "国华投资大厦1105室"
                                }
                            ]
                        }
                    }
                """
            }
        }

]