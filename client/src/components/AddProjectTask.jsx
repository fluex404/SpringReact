import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {addProjectTask} from '../actions/ProjectTaskActions';

class AddProjectTask extends Component {
  constructor() {
    super();
    this.state = {
      summary: "",
      acceptanceCriteria: "",
      status: "",
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
  }
  componentWillReceiveProps(nextProps) {
    if(nextProps.errors) {
      this.setState({errors: nextProps.errors});
    }
  }
  onChange(e) {
    this.setState({[e.target.name]: e.target.value});
  }

  handleClick = (e) => {
    e.preventDefault();
    const newProjectTask = {
      summary: this.state.summary,
      acceptanceCriteria: this.state.acceptanceCriteria,
      status: this.state.status
    };
    // console.log(newProjectTask);
    this.props.addProjectTask(newProjectTask, this.props.history);
  }

  render() {
    return (
      <div className="addProjectTask">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <Link to="/" className="btn btn-light">
                Back to Board
              </Link>
              <h4 className="display-4 text-center">
                Add /Update Project Task
              </h4>
              <form>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    name="summary"
                    placeholder="Project Task summary"
                    valule={this.state.summary}
                    onChange={this.onChange}
                  />
                </div>
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Acceptance Criteria"
                    name="acceptanceCriteria"
                    onChange={this.onChange}
                    value={this.state.acceptanceCriteria}
                  />
                </div>
                <div className="form-group">
                  <select
                    className="form-control form-control-lg"
                    name="status"
                    onChange={this.onChange}
                    value={this.state.status}
                  >
                    <option value="">Select Status</option>
                    <option value="TO_DO">TO DO</option>
                    <option value="IN_PROGRESS">IN PROGRESS</option>
                    <option value="DONE">DONE</option>
                  </select>
                </div>
                <input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                  onClick={this.handleClick}
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddProjectTask.propTypes = {
  addProjectTask: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(mapStateToProps, {addProjectTask}) (AddProjectTask);
