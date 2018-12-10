import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store";
import Contacts from "./components/contacts/Contacts";
import EditContact from "./components/contacts/EditContact";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <div className="container">
              <Switch>
                <Route exact path="/" component={Contacts} />
                <Route exact path="/contact/edit/:id" component={EditContact} />
              </Switch>
            </div>
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
