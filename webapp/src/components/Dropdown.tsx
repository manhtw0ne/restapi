import React from 'react'

const Dropdown = () => {
  return (
    <div className='mb-3'>
      <label htmlFor="category" className="htmlFor form-label">
        Category
      </label>
      <select name={name} id={id} className='form-control' onChange={onchange} onBlur={onBlur} value={value}>
        <option value="" label="Select Category" />
        {options.map((option) => (
            <option key={option} value={option} label={option} />
        ))}
    </select>
    {touched && error ? (

        <div className='text-danger fst-italic'>{error}</div>
    ) : null}
    </div>
  )
};

export default Dropdown;
