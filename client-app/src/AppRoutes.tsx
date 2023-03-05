import MainPage from "./pages/main_page/MainPage";
import CreateGamePage from "./pages/create-game/CreateGamePage";


export type RouteElement = {
    path: string,
    component: any,
}

const routes: RouteElement[] = [
    {path: "/", component: <MainPage/>},
    {path: "/create-game", component: <CreateGamePage/>}
];

export default routes;