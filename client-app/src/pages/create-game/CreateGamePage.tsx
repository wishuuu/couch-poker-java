import {Component} from "react";

type CreateGamePageState = {
    connectionString: string;
    maxPlayers: number;
    minPlayers: number;
    startChips: number;
}

export default class CreateGamePage extends Component {
    static displayName = CreateGamePage.name;

    constructor(props: CreateGamePageState) {
        super(props);
    }

    state: CreateGamePageState = {
        connectionString: "",
        maxPlayers: 6,
        minPlayers: 2,
        startChips: 1000
    }

    render() {
        return (
            <div className={"absolute translate-x-[-50%] translate-y-[-50%] top-[45%] left-[50%]"}>
                <div className={"font-sans card bg-base-300 p-8"}>
                    <div className={"w-96"}>
                        <h1 className={"text-center font-bold"}>
                            Create Game
                        </h1>
                        <form
                            onSubmit={e => {
                                e.preventDefault();
                                console.log("submit");
                            }}
                            className={"form-control card-body"}>

                            <label className={"label"}>
                                <span className={"label-text"}>Max Players</span>
                            </label>
                            <input type="number" className={"input input-bordered"} placeholder={"Max Players"}
                                   value={this.state.maxPlayers}
                                   onChange={e => {
                                       this.setState({maxPlayers: parseInt(e.target.value)});
                                   }}/>

                            <label className={"label"}>
                                <span className={"label-text"}>Min Players</span>
                            </label>
                            <input type="number" className={"input input-bordered"} placeholder={"Min Players"}
                                   value={this.state.minPlayers}
                                   onChange={e => {
                                       this.setState({minPlayers: parseInt(e.target.value)});
                                   }}/>

                            <label className={"label"}>
                                <span className={"label-text"}>Start Chips</span>
                            </label>
                            <input type="number" className={"input input-bordered"} placeholder={"Start Chips"}
                                   value={this.state.startChips}
                                   onChange={e => {
                                       this.setState({startChips: parseInt(e.target.value)});
                                   }}/>
                            <br/>
                            <input type={"submit"} className={"btn btn-primary"} value={"Create Game"}/>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}