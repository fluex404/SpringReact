import React, { Component } from 'react';
import './App.css';
import ProjectBoard from './components/ProjectBoard';
import Navbar from './components/Navbar';
import AddProjectTask from './components/ProjectTask/AddProjectTask';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {Provider} from 'react-redux';
import store from './store';

class App extends Component {

  render() {
    return (
      <Provider>
        <Router>
          <div>
            <Navbar/>
            <Route exact path="/" component={ProjectBoard} />
            <Route exact path="/addProjectTask" component={AddProjectTask} />
          </div>
        </Router>
      </Provider>
    );
  }
}
export default App;
