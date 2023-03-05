import React, {useState} from 'react'
import {Routes, Route} from 'react-router-dom'
import {Layout} from "./components/Layout";
import AppRoutes, {RouteElement} from "./AppRoutes";

function App() {
    return (
        <Layout>
            <Routes>
                {AppRoutes.map((route: RouteElement, index: number) => {
                    return <Route
                        key={index}
                        path={route.path}
                        element={route.component}/>
                })}
            </Routes>
        </Layout>
    )
}

export default App
