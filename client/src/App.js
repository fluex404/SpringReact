import React, { Component } from 'react';
import Axios from "axios";
import './App.css';

class App extends Component {

  handleClick = () => {
    Axios.delete("http://localhost:8080/api/board/fcbb31c2-ff00-471a-ab0f-2b45c43ac612")
    .then(r => console.log(r));
  }

  render() {
    return (
      <div className="container">
        <button className="btn btn-danger" onClick={this.handleClick}>button</button>
      </div>
    );
  }
}
export default App;
