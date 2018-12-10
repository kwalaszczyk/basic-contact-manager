import {
  GET_CONTACTS,
  DELETE_CONTACT,
  GET_CONTACT,
  UPDATE_CONTACT
} from "./types";

import axios from "axios";

export const getContacts = () => async dispatch => {
  const res = await axios.get("/api/contacts");
  dispatch({
    type: GET_CONTACTS,
    payload: res.data
  });
};

export const getContact = id => async dispatch => {
  const res = await axios.get(`/api/contacts/${id}`);
  dispatch({
    type: GET_CONTACT,
    payload: res.data
  });
};

export const updateContact = contact => async dispatch => {
  const res = await axios.put(`/api/contacts/${contact.id}`, contact);
  dispatch({
    type: UPDATE_CONTACT,
    payload: res.data
  });
};

export const deleteContact = id => async dispatch => {
  await axios.delete(`/api/contacts/${id}`);
  dispatch({
    type: DELETE_CONTACT,
    payload: id
  });
};
