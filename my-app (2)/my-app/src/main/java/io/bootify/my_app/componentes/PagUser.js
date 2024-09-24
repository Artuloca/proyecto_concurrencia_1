import React from 'react';

function UserScreen({ onLogout }) {
    return (
        <div>
            <h1>User Screen</h1>
            <button onClick={onLogout}>Volver</button>
        </div>
    );
}

export default UserScreen;