import userService from "./user-service"
const {useState, useEffect} = React;
const {useParams, useHistory, Link} = window.ReactRouterDOM;

const UserEditor = () => {
    const {userId} = useParams()
    const [user, setUser] = useState({})
    const [courses, setCourses] = useState([])

    const history = useHistory()
    useEffect(() => {
        if (userId !== "new") {
            findUserById(userId)
            findOwnedCourses(userId);
        }
    }, [])
    const createUser = (user) =>
        userService.createUser(user)
            .then(() => history.goBack())
    const findUserById = (userId) =>
        userService.findUserById(userId).then(user => setUser(user))
    const deleteUser = (id) =>
        userService.deleteUser(id)
            .then(() => history.goBack())
    const updateUser = (id, newUser) =>
        userService.updateUser(id, newUser)
            .then(() => history.goBack())
    const findOwnedCourses = (userId) =>
        userService.findOwnedCourses(userId)
            .then(course => setCourses(course))

    return (
        <div>
            <h2>User Editor</h2>
            <label>ID</label>
            <input value={user.id} className="form-control"/><br/>
            <label>First Name</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, firstName: e.target.value}))}
                value={user.firstName} className="form-control"/><br/>
            <label>Last Name</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, lastName: e.target.value}))}
                value={user.lastName} className="form-control"/><br/>
            <label>Date of Birth</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, dateOfBirth: e.target.value}))}
                value={user.dateOfBirth} className="form-control"/><br/>
            <label>Username</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, username: e.target.value}))}
                value={user.username} className="form-control"/><br/>
            <label>Password</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, password: e.target.value}))}
                value={user.password} className="form-control"/><br/>
            <label>Email</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, email: e.target.value}))}
                value={user.email} className="form-control"/><br/>
            <h2>Owned Courses</h2>
            {
                userId !== 'new' && user &&
                <ul>
                    {courses.map((course) => {
                        return (
                            <li>
                                <Link to={`/courses/${course.id}`} >
                                    {course.id},
                                    {course.courseName},
                                    {course.topic}
                                </Link>
                            </li>
                        )
                    })
                    }
                </ul>
            }
            <button
                onClick={() => {
                    history.goBack()}}>
                Cancel
            </button>
            <button
                onClick={() => deleteUser(user.id)}>
                Delete
            </button>
            <button
                onClick={() => createUser(user)}>
                Create
            </button>
            <button
                onClick={() => updateUser(user.id, user)}>
                Save
            </button>
        </div>
    )
}

export default UserEditor