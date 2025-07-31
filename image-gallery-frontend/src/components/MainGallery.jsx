import React, { useEffect, useState } from 'react';
import UploadForm from './UploadForm';
import ImageGrid from './ImageGrid';
import SearchBar from './SearchBar';
import BulkDeleteButton from './BulkDeleteButton';
import { fetchImages, deleteImages } from '../api/imageService';
import axios from 'axios';

function MainGallery() {
  const [images, setImages] = useState([]);
  const [selectedIds, setSelectedIds] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [category, setCategory] = useState('');

  const loadImages = async () => {
    const res = await fetchImages();
    setImages(res.data);
  };

  useEffect(() => {
    loadImages();
  }, []);

  const handleDelete = async () => {
    await deleteImages(selectedIds);
    loadImages();
    setSelectedIds([]);
  };

  const handleSort = async () => {
    const res = await axios.get("https://image-gallery-zbk5.onrender.com/sort");
    setImages(res.data);
  };

  return (

    <div className="min-vh-100" style={{ backgroundColor: '#f8f9fa' }}>
  <div className="container py-4">
    <h2 className="text-center mb-4 d-flex justify-content-center align-items-center gap-2">
      <i className="bi bi-camera-fill text-primary fs-3"></i>
      <span className="fw-bold text-primary">Image Gallery</span>
    </h2>

      <div className="card shadow-sm p-4 mb-4">
        <UploadForm onUpload={loadImages} />
      </div>

      <div className="card shadow-sm p-4 mb-4">
        <SearchBar
          searchTerm={searchTerm}
          setSearchTerm={setSearchTerm}
          category={category}
          setCategory={setCategory}
        />
      </div>

      <div className="d-flex justify-content-between align-items-center mb-3">
        <BulkDeleteButton onDelete={handleDelete} disabled={selectedIds.length === 0} />
        <button className="btn btn-outline-primary" onClick={handleSort}>
          <i className="bi bi-sort-down"></i> Sort by Date
        </button>
      </div>

      <ImageGrid
        images={images}
        selectedIds={selectedIds}
        setSelectedIds={setSelectedIds}
        searchTerm={searchTerm}
        category={category}
      />
    </div>
    </div>
  );
}

export default MainGallery;
