import { GET_CONTACTS } from "./types";

import axios from "axios";

export const getContacts = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/api/contacts");
  console.log(res.data);
};
