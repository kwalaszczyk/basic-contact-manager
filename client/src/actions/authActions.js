import { SET_CURRENT_USER } from "./types";
import setAuthToken from "../utils/setAuthToken";
import jwt_decode from "jwt-decode";
import axios from "axios";

export const loginUser = user => async dispatch => {
  axios
    .post("/login", user)
    .then(res => {
      const token = res.data;
      localStorage.setItem("jwtToken", token);

      setAuthToken(token);

      const decoded = jwt_decode(token);

      dispatch(setCurrentUser(decoded));
    })
    .catch(console.log);
};

export const registerUser = user => async dispatch => {
  axios
    .post("/api/users/signup", user)
    .then(res => {
      const token = res.data;
      localStorage.setItem("jwtToken", token);

      setAuthToken(token);

      const decoded = jwt_decode(token);

      dispatch(setCurrentUser(decoded));
    })
    .catch(console.log);
};

export const logoutUser = history => async dispatch => {
  localStorage.removeItem("jwtToken");
  setAuthToken(false);
  if (history != null) history.push("/");
  dispatch(setCurrentUser({}));
};

export const setCurrentUser = decoded => {
  return {
    type: SET_CURRENT_USER,
    payload: decoded
  };
};
