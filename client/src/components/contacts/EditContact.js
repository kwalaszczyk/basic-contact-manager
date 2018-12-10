import React, { Component } from "react";
import InputTextField from "../layout/InputTextField";

class EditContact extends Component {
  state = {
    name: "",
    surname: "",
    phone: "",
    errors: {}
  };

  componentWillReceiveProps(nextProps) {
    const { name, surname, phone } = nextProps.contact;
    this.setState({
      name,
      surname,
      phone
    });
  }

  componentDidMount() {
    const { id } = this.props.match.params;
  }

  onChange = e => this.setState({ [e.target.name]: e.target.value });

  onSubmit = e => {
    e.preventDefault();
    this.props.history.push("/");
  };

  render() {
    const { name, surname, phone, errors } = this.state;
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
                label="Phone"
                name="phone"
                placeholder="Enter Phone"
                value={phone}
                onChange={this.onChange}
                error={errors.phone}
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

export default EditContact;
