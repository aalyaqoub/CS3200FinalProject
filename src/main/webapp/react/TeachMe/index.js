import UserList from "./users/user-list";
import UserEditor from "./users/user-editor";
import CourseList from "./courses/course-list";
import CourseEditor from "./courses/course-editor";
import Home from "./home";
import LessonList from "./lessons/lesson-list";
import LessonEditor from "./lessons/lesson-editor";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <h1>TeachMe</h1>
                <Route path="/" exact={true}>
                    <Home/>
                </Route>
                <Route path={["/users"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:userId" exact={true}>
                    <UserEditor/>
                </Route>
                <Route path={["/courses"]} exact={true}>
                    <CourseList/>
                </Route>
                <Route path="/courses/:courseId" exact={true}>
                    <CourseEditor/>
                </Route>
                <Route path={["/lessons"]} exact={true}>
                    <LessonList/>
                </Route>
                <Route path="/lessons/:lessonId" exact={true}>
                    <LessonEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
