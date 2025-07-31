import axios from 'axios';
const API_URL = 'https://image-gallery-zbk5.onrender.com';

export const fetchImages = () => axios.get(`${API_URL}/getAll`);
export const uploadImage = (formData) => axios.post(`${API_URL}/upload`, formData);
export const deleteImages = (ids) => axios.delete(`${API_URL}/deleteAll`, { data: ids });
export const sortImagesByDate = () => axios.get(`${API_URL}/sort`);