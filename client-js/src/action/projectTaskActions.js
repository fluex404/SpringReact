import axios from "axios";
import { GET_ERRORS, GET_PROJECT_TASKS } from "./types";

export const addProjectTask = (project_task, history) => async dispatch => {
  try {
    await axios.post("http://localhost:8080/api/board", project_task);
    history.push("/");

    dispatch({
        type: GET_ERRORS,
        payload: {}
    });
  } catch (error) {
    dispatch({
        type: GET_ERRORS,
        payload: error.response.data
    });
  }
};

export const getBacklog = () => async dispatch => {
  const rest = await axios.get("http://localhost:8080/api/board");
  dispatch({
    type: GET_PROJECT_TASKS,
    payload: rest.data
  });
}