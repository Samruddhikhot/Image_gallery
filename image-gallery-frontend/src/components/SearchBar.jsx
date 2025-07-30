import React from 'react';

function SearchBar({ searchTerm, setSearchTerm, category, setCategory }) {
  return (
    <div className="p-3 mb-4 bg-white border rounded shadow-sm">
      <div className="row g-3 align-items-end">
        <div className="col-md-6">
          <label className="form-label fw-semibold">🔍 Search by Title</label>
          <input
            type="text"
            className="form-control"
            placeholder="e.g. Sunset, Portrait"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
        </div>
        <div className="col-md-6">
          <label className="form-label fw-semibold">📁 Filter by Category</label>
          <input
            type="text"
            className="form-control"
            placeholder="e.g. Nature, People"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          />
        </div>
      </div>
    </div>
  );
}

export default SearchBar;
