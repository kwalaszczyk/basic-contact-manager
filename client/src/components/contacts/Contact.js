import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteContact } from "../../actions/contactActions";

class Contact extends Component {
  onDeleteClick = id => {
    this.props.deleteContact(id);
  };

  render() {
    const { id, name, surname, phoneNumber } = this.props.contact;

    return (
      <div className="card card-body mb-3">
        <h4>
          {name} {surname}
          <i
            className="fas fa-times"
            onClick={this.onDeleteClick.bind(this, id)}
          />
          <Link to={`contact/${id}`}>
            <i className="fas fa-pencil-alt" />
          </Link>
        </h4>
        <ul className="list-group">
          <li className="list-group-item">Phone: {phoneNumber}</li>
        </ul>
      </div>
    );
  }
}
Contact.propTypes = {
  contact: PropTypes.object.isRequired,
  deleteContact: PropTypes.func.isRequired
};

export default connect(
  null,
  { deleteContact }
)(Contact);
