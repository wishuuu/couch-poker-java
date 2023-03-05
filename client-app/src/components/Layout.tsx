import {Component} from "react";

type Props = {
    children: JSX.Element;
}

export class Layout extends Component<Props> {
    render() {
        return (
            <div className="container">
                {/* <NavBar /> TODO Create NavBar */}
                {this.props.children}
            </div>
        )
    }
}