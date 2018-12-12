import React, { Component } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import { logoutUser } from "../../actions/authActions";
import { clearContacts } from "../../actions/contactActions";
import { withRouter } from "react-router-dom";

class Header extends Component {
  onLogoutClick = ev => {
    ev.preventDefault();
    this.props.logoutUser(this.props.history);
    this.props.clearContacts();
  };
  render() {
    const { isAuthenticated, user } = this.props.auth;

    const authLinks = (
      <React.Fragment>
        <li className="nav-item">
          <Link to="/contact/add" className="nav-link">
            <i className="fas fa-plus" /> Add
          </Link>
        </li>
        <li className="nav-item">
          <a
            onClick={this.onLogoutClick}
            className="nav-link"
            style={{ cursor: "pointer" }}
          >
            <i className="fas fa-sign-out-alt" /> Logout ({user.sub})
          </a>
        </li>
      </React.Fragment>
    );

    const guestLinks = (
      <React.Fragment>
        <li className="nav-item">
          <Link to="/login" className="nav-link">
            <i className="fa fa-user" /> LogMe
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/signup" className="nav-link">
            <i className="fa fa-user-plus" /> SignUp
          </Link>
        </li>
      </React.Fragment>
    );

    return (
      <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-3 py-0">
        <div className="container">
          <Link to="/" className="navbar-brand">
            Contact Manager
          </Link>
          <div>
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to="/" className="nav-link">
                  <i className="fas fa-home" /> Home
                </Link>
              </li>
              <li className="nav-item">
                <Link to="/about" className="nav-link">
                  <i className="fas fa-question" /> About
                </Link>
              </li>
              {isAuthenticated ? authLinks : guestLinks}
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(
  mapStateToProps,
  { logoutUser, clearContacts }
)(withRouter(Header));
