import React from "react";
import PropTypes from "prop-types";
import classnames from "classnames";

const InputTextField = ({
  label,
  name,
  value,
  placeholder,
  type,
  onChange,
  onBlur,
  error,
  showMarkError
}) => {
  return (
    <div className="form-group">
      <label htmlFor={name}>{label}</label>
      <input
        type={type}
        name={name}
        className={classnames("form-control form-control-lg", {
          "is-invalid": showMarkError
        })}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        onBlur={onBlur}
      />
      {showMarkError && <div className="invalid-feedback">{error}</div>}
    </div>
  );
};

InputTextField.propTypes = {
  label: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  placeholder: PropTypes.string.isRequired,
  value: PropTypes.string.isRequired,
  type: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
  onBlur: PropTypes.func.isRequired,
  error: PropTypes.string,
  showMarkError: PropTypes.func.isRequired
};

InputTextField.defaultProps = {
  type: "text"
};

export default InputTextField;
