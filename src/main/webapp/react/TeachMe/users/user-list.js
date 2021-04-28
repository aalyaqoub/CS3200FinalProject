import usersService from "./user-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const UserList = () => {
    const [users, setUsers] = useState([])

    const history = useHistory()

    useEffect(() => {
        findAllUsers()
    }, [])

    const findAllUsers = () => {
        usersService.findAllUsers()
            .then((data) => {
                setUsers(data)
            })

    }


    return (
        <div>
            <h2>User Lists {users.length}</h2>
            <ul>
                {users.map((user) => {
                    return (
                        <li>
                            <Link to={`/users/${user.id}`} >
                                {user.id},
                                {user.firstName},
                                {user.lastName}
                            </Link>
                        </li>
                    )
                })
                }
            </ul>
            <button onClick={() =>
            {history.push("/users/new")}}>
                Add User
            </button>
        </div>
    )
}

export default UserList