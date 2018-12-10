import { GET_CONTACTS } from "./types";

import axios from "axios";

export const getContacts = () => async dispatch => {
  const res = await axios.get("/api/contacts");
  dispatch({
    type: GET_CONTACTS,
    payload: res.data
  });
};
