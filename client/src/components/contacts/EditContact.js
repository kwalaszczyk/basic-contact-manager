import React, { Component } from "react";
import InputTextField from "../layout/InputTextField";
import { getContact, updateContact } from "../../actions/contactActions";
import { connect } from "react-redux";

class EditContact extends Component {
  state = {
    name: "",
    surname: "",
    phoneNumber: "",
    errors: {}
  };

  componentWillReceiveProps(nextProps) {
    const { name, surname, phoneNumber } = nextProps.contact;
    this.setState({
      name,
      surname,
      phoneNumber
    });
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getContact(id);
  }

  onChange = e => this.setState({ [e.target.name]: e.target.value });

  onSubmit = e => {
    e.preventDefault();
    const { name, surname, phoneNumber } = this.state;

    // Check For Errors
    if (name === "") {
      this.setState({ errors: { name: "Name is required" } });
      return;
    }

    if (surname === "") {
      this.setState({ errors: { surname: "Surname is required" } });
      return;
    }

    if (phoneNumber === "") {
      this.setState({ errors: { phoneNumber: "Phone is required" } });
      return;
    }

    const { id } = this.props.match.params;

    const updContact = {
      id,
      name,
      surname,
      phoneNumber
    };

    this.props.updateContact(updContact);

    // Clear State
    this.setState({
      name: "",
      surname: "",
      phoneNumber: "",
      errors: {}
    });
    this.props.history.push("/");
  };

  render() {
    const { name, surname, phoneNumber, errors } = this.state;
    return (
      <div>
        <div className="card mb-3">
          <div className="card-header">Edit Contact</div>
          <div className="card-body">
            <form onSubmit={this.onSubmit}>
              <InputTextField
                label="Name"
                name="name"
                placeholder="Enter Name"
                value={name}
                onChange={this.onChange}
                error={errors.name}
              />
              <InputTextField
                label="Surname"
                name="surname"
                type="surname"
                placeholder="Enter Surname"
                value={surname}
                onChange={this.onChange}
                error={errors.surname}
              />
              <InputTextField
                label="phoneNumber"
                name="phoneNumber"
                placeholder="Enter Phone"
                value={phoneNumber}
                onChange={this.onChange}
                error={errors.phoneNumber}
              />
              <div className="text-center">
                <input
                  type="submit"
                  value="Update Contact"
                  className="btn btn-success"
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToPros = state => ({
  contact: state.contact.contact
});

export default connect(
  mapStateToPros,
  { getContact, updateContact }
)(EditContact);
