import { useEffect, useState } from "react";
import { getAllStudents, addStudent, updateStudent, deleteStudent } from "../api/studentapi";
import StudentForm from "../components/studentForm";
import StudentList from "../components/studentList";

const StudentPage = () => {
  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);

  const loadStudents = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  useEffect(() => {
    loadStudents();
  }, []);

  const handleSave = async (student) => {
    if (selectedStudent) {
      await updateStudent(selectedStudent.id, student);
    } else {
      await addStudent(student);
    }
    setSelectedStudent(null);
    loadStudents();
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure?")) {
      await deleteStudent(id);
      loadStudents();
    }
  };

  return (
    <div>
      <StudentForm
        onSave={handleSave}
        selectedStudent={selectedStudent}
        onCancel={() => setSelectedStudent(null)}
      />
      <StudentList
        students={students}
        onEdit={setSelectedStudent}
        onDelete={handleDelete}
      />
    </div>
  );
};

export default StudentPage;
