import React, { Component } from "react";
import InputTextField from "../layout/InputTextField";
import { connect } from "react-redux";
import { loginUser } from "../../actions/authActions";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      email: "",
      password: "",
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
  }
  onSubmit = ev => {
    ev.preventDefault();
    const loginUser = {
      email: this.state.email,
      password: this.state.password
    };
    this.props.loginUser(loginUser);
  };

  componentDidMount() {
    if (this.props.auth.isAuthenticated) {
      this.props.history.push("/");
    }
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.auth.isAuthenticated) {
      this.props.history.push("/");
    }

    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  onChange = ev => this.setState({ [ev.target.name]: ev.target.value });

  render() {
    const { errors } = this.state;
    return (
      <div className="login custom-template">
        <div className="container">
          <div className="row">
            <div className="col-md-4 m-auto">
              <h1 className="heading text-center">Log in</h1>
              <form onSubmit={this.onSubmit}>
                <InputTextField
                  type="email"
                  placeholder="Email Address"
                  name="email"
                  value={this.state.email}
                  onChange={this.onChange}
                  error={errors.email}
                />
                <InputTextField
                  type="password"
                  placeholder="Password"
                  name="password"
                  value={this.state.password}
                  onChange={this.onChange}
                  error={errors.password}
                />
                <input type="submit" className="btn btn-info" />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(
  mapStateToProps,
  { loginUser }
)(Login);
