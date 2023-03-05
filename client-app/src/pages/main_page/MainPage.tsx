import {Component} from "react";

export default class MainPage extends Component {
    render() {
        return (
            <div>
                <h1>Main Page</h1>
                <a
                    className="btn btn-primary"
                    href="/create-game">
                    Create Game
                </a>
            </div>
        );
    }
}