Group 36 CSCI 5448 Final Project
================================

For our final project, we are creating a website that allows CU
students to sell their used goods, instead of throwing them away at the end of the semester.

## Server API

| Path | Method | Use | Auth Required |
| ---- |:------:|:---:|:-------------:|
| `/` | `GET` | Index | No |
| `/register` | `GET` | Registration Page | No |
| `/register` | `POST` | Send Registration Form | No |
| `/login` | `GET` | Login Page | No |
| `/login` | `POST` | Attempt Login | No |
| `/home` | `GET` | Home Page | Yes |
| `/items/posted` | `GET` | My Posted Items Page | Yes |
| `/items/post` | `GET` | Post New Item Page | Yes |
| `/items/post` | `POST` | Send Post New Item Form | Yes |
| `/items/post/success` | `GET` | Item Posted Page | Yes |
