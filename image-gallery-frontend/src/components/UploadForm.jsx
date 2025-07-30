import React, { useState } from 'react';
import { uploadImage } from '../api/imageService';

function UploadForm({ onUpload }) {
  const [file, setFile] = useState(null);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [category, setCategory] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append('file', file);
    formData.append('title', title);
    formData.append('description', description);
    formData.append('category', category);
    await uploadImage(formData);
    onUpload();

    // Reset fields after upload
    setFile(null);
    setTitle('');
    setDescription('');
    setCategory('');
  };

  return (
    <form className="p-3 mb-4 bg-light border rounded shadow-sm" onSubmit={handleSubmit}>
      <div className="row g-2 align-items-end">
        <div className="col-md-3">
          <label className="form-label fw-bold">Choose Image</label>
          <input
            type="file"
            className="form-control"
            onChange={(e) => setFile(e.target.files[0])}
            required
          />
        </div>
        <div className="col-md-2">
          <label className="form-label fw-bold">Title</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          />
        </div>
        <div className="col-md-3">
          <label className="form-label fw-bold">Description</label>
          <input
            type="text"
            className="form-control"
            placeholder="Short description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <div className="col-md-2">
          <label className="form-label fw-bold">Category</label>
          <input
            type="text"
            className="form-control"
            placeholder="e.g. Nature"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
            required
          />
        </div>
        <div className="col-md-2">
          <button type="submit" className="btn btn-success w-100">📤 Upload</button>
        </div>
      </div>
    </form>
  );
}

export default UploadForm;
