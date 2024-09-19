import React from 'react';
import ReactDOM from 'react-dom';
import Login from './Login';

const App = () => {
    return (
        <div>
            <Login />
        </div>
    );
};

ReactDOM.render(<App />, document.getElementById('root'));