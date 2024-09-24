import React, { useState, ChangeEvent } from 'react';

const AdminPanel: React.FC = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [userId, setUserId] = useState('');

    const handleAddUser = async () => {
        try {
            const response = await fetch('/api/users/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            if (response.ok) {
                console.log('User added successfully');
            } else {
                console.error('Failed to add user');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const handleDeleteUser = async () => {
        try {
            const response = await fetch(`/api/users/delete/${userId}`, {
                method: 'DELETE',
            });

            if (response.ok) {
                console.log('User deleted successfully');
            } else {
                console.error('Failed to delete user');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const handleUsernameChange = (e: ChangeEvent<HTMLInputElement>) => {
        setUsername(e.target.value);
    };

    const handlePasswordChange = (e: ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value);
    };

    const handleUserIdChange = (e: ChangeEvent<HTMLInputElement>) => {
        setUserId(e.target.value);
    };

    return (
        <div>
            <h2>Admin Panel</h2>
            <div>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={handleUsernameChange}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={handlePasswordChange}
                />
                <button onClick={handleAddUser}>Add User</button>
            </div>
            <div>
                <input
                    type="text"
                    placeholder="User ID"
                    value={userId}
                    onChange={handleUserIdChange}
                />
                <button onClick={handleDeleteUser}>Delete User</button>
            </div>
        </div>
    );
};

export default AdminPanel;