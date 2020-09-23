import React from 'react'
import {BrowserRouter as Router, Route} from 'react-router-dom';
import LoginPage from "./Login/LoginPage";
import NewUserPage from "./Login/NewUserPage";

export default function AppComponent() {
  return <div>
      <Router>
        <div>
          <Route exact path="/" component={LoginPage} />
            <Route exact path="/new" component={NewUserPage} />
        </div>
      </Router>
    </div>
}
