REST Microservice for a Simple Interest Loan Calculator
=======================================================

This microservice exposes a single endpoint (```/interest```) that takes a POST request with the required variables

```json
{
  "amount": 100.0,
  "rate": 0.3,
  "terms": 10
}
```
The data has the following ranges:

- amount (Double): ```[1.0, 999999.0]```
- rate (Double): ```[0.01, 1.0]```
- terms (Integer): ```[4, 52]```

