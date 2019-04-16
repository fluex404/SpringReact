import React from 'react';
import {Link} from 'react-router-dom';

function Navbar() {
  return (
    <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        {/*<!-- NavBar Component Code -->*/}
        <div className="container">
            <Link className="navbar-brand" to="/">
                Project Task
            </Link>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                <span className="navbar-toggler-icon" />
            </button>
        </div>
    </nav>
  )
}
export default Navbar;