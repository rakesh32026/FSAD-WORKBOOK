import React, { useState } from "react";
import axios from "axios";

function AddStudent({ fetchStudents, editStudent, setEditStudent }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (editStudent) {
      await axios.put(`http://localhost:8080/students/${editStudent.id}`, student);
      setEditStudent(null);
    } else {
      await axios.post("http://localhost:8080/students", student);
    }

    setStudent({ name: "", email: "", course: "" });
    fetchStudents();
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />
      <button type="submit">{editStudent ? "Update" : "Add"}</button>
    </form>
  );
}

export default AddStudent;