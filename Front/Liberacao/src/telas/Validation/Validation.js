import React, { Component } from 'react';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './Validation.css';

//Marcelo

const emailRegex = RegExp(
  /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
);


const formValid = formErrors => {
  let valid = true;

  Object.values(formErrors).forEach(val => {
    val.length > 0 && (valid = false)
  })
};

export default class Validation extends Component {

  showSettings(event) {
    event.preventDefault();
  }


  constructor(props) {
    super(props);
    this.state = {
      firstName: null,
      lastName: null,
      email: null,
      password: null,
      formErrors: {
        firstName: '',
        lastName: '',
        email: '',
        password: ''
      }
    };
  }


  handleSubmit = e => {
    e.preventDefault();
    if (formValid(this.state.formErrors)) {
      console.log(`
      -- SUBMIT --
      FirstName: ${this.state.formErrors.firstName}
      LastName: ${this.state.formErrors.lastName}
      Email: ${this.state.formErrors.email}
      Password: ${this.state.formErrors.password}

      `)
    } else {
      console.log(
        `Invalid Form - Error Message`
      )
    }
  }

  handleChange = e => {
    e.preventDefault();
    const { name, value } = e.target;
    let formErrors = this.state.formErrors;

    switch (name) {
      case 'firstName':
        formErrors.firstName = value.length < 3 && value.length > 0 ? 'minimum 3 characters required' : ''
        break;
      case 'lastName':
        formErrors.lastName = value.length < 3 && value.length > 0 ? 'minimum 3 characters required' : ''
        break;
      case 'email':
        formErrors.email = emailRegex.test(value)  && value.length > 0 ? '' : 'invalid email address'
        break;
      case 'password':
        formErrors.password = value.length < 6 && value.length > 0 ? 'minimum 6 characters required' : ''
        break;

      default:
        break;
    }
    this.setState({ formErrors, [name] : value}, () => console.log(this.state));

  }

  render() {
    return (
      <div className="wrapper">
        <div className="form-wrapper">
          <h1>Validation Test</h1>
          <form onSubmit={this.handleSubmit} noValidate>
            <div className="firstName">
              <label htmlFor="firstName">First Name</label>
              <input
                type="text"
                className=""
                placeholder="First Name"
                name="firstName"
                noValidate
                onChange={this.handleChange}
              />
            </div>
            <div className="lastName">
              <label htmlFor="lastName">Last Name</label>
              <input
                type="text"
                className=""
                placeholder="Last Name"
                name="lastName"
                noValidate
                onChange={this.handleChange}
              />
            </div>
            <div className="email">
              <label htmlFor="email">Email</label>
              <input
                type="email"
                className=""
                placeholder="Email"
                name="email"
                noValidate
                onChange={this.handleChange}
              />
            </div>
            <div className="password">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                className=""
                placeholder="Password"
                name="password"
                noValidate
                onChange={this.handleChange}
              />
            </div>
            <div className="createAccount">
              <button type="submit">Create Account</button>
              <small>Already have an account here?</small>
            </div>

          </form>
        </div>
      </div>

    );
  }
}