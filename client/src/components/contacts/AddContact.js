import React, { Component } from "react";
import InputTextField from "../layout/InputTextField";
import { addContact } from "../../actions/contactActions";
import { connect } from "react-redux";
import PropTypes from "prop-types";

class AddContact extends Component {
  state = {
    name: "",
    surname: "",
    phoneNumber: "",
    touched: {
      name: false,
      surname: false,
      phoneNumber: false
    }
  };

  handleBlur = field => evt => {
    this.setState({
      touched: { ...this.state.touched, [field]: true }
    });
  };

  onChange = e => this.setState({ [e.target.name]: e.target.value });

  onSubmit = e => {
    e.preventDefault();
    const { name, surname, phoneNumber } = this.state;

    const newContact = {
      name,
      surname,
      phoneNumber
    };

    this.props.addContact(newContact);

    this.setState({
      name: "",
      surname: "",
      phoneNumber: "",
      errors: {}
    });

    this.props.history.push("/");
  };

  validateFields = (name, surname, phoneNumber) => {
    return {
      name: name.length === 0 ? "Name field cannot be empty" : false,
      surname: surname.length === 0 ? "Surname field cannot be empty" : false,
      phoneNumber:
        phoneNumber.length === 0 ? "Phone number field cannot be empty" : false
    };
  };

  render() {
    const shouldMarkError = field => {
      const hasError = errors[field];
      const shouldShow = this.state.touched[field];
      return hasError && shouldShow;
    };
    const { name, surname, phoneNumber } = this.state;
    const errors = this.validateFields(name, surname, phoneNumber);
    const isEnabled = !Object.keys(errors).some(x => errors[x]);
    return (
      <div>
        <div className="card mb-3">
          <div className="card-header">Add Contact</div>
          <div className="card-body">
            <form onSubmit={this.onSubmit}>
              <InputTextField
                label="Name"
                name="name"
                placeholder="Enter Name"
                onChange={this.onChange}
                onBlur={this.handleBlur("name")}
                error={errors.name}
                showMarkError={shouldMarkError("name")}
              />
              <InputTextField
                label="Surname"
                name="surname"
                type="surname"
                placeholder="Enter Surname"
                onChange={this.onChange}
                onBlur={this.handleBlur("surname")}
                error={errors.surname}
                showMarkError={shouldMarkError("surname")}
              />
              <InputTextField
                label="Phone Number"
                name="phoneNumber"
                placeholder="Enter Phone"
                onChange={this.onChange}
                onBlur={this.handleBlur("phoneNumber")}
                error={errors.phoneNumber}
                showMarkError={shouldMarkError("phoneNumber")}
              />

              <div className="text-center">
                <input
                  type="submit"
                  className="btn btn-success"
                  value="Submit"
                  disabled={!isEnabled}
                  style={!isEnabled ? { cursor: "not-allowed" } : {}}
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

AddContact.propTypes = {
  addContact: PropTypes.func.isRequired
};

export default connect(
  null,
  { addContact }
)(AddContact);
