import React from 'react';

function ImageGrid({ images, selectedIds, setSelectedIds, searchTerm, category }) {
  const filtered = images.filter(img =>
    img.title.toLowerCase().includes(searchTerm.toLowerCase()) &&
    img.category.toLowerCase().includes(category.toLowerCase())
  );

  const toggleSelect = (id) => {
    if (selectedIds.includes(id)) {
      setSelectedIds(selectedIds.filter(i => i !== id));
    } else {
      setSelectedIds([...selectedIds, id]);
    }
  };

  return (
    <div className="row">
      {filtered.length > 0 ? (
        filtered.map(img => (
          <div key={img.id} className="col-sm-6 col-md-4 col-lg-3 mb-4">
            <div
              className={`card h-100 shadow-sm ${selectedIds.includes(img.id) ? 'border border-3 border-danger' : ''}`}
              onClick={() => toggleSelect(img.id)}
              style={{ cursor: 'pointer', transition: 'transform 0.2s' }}
            >
              <img
                src={`data:image/jpeg;base64,${img.imageData}`}
                className="card-img-top img-fluid rounded-top"
                alt={img.title}
                style={{ height: '200px', objectFit: 'cover' }}
              />
              <div className="card-body d-flex flex-column justify-content-between">
                <div>
                  <h5 className="card-title text-primary">{img.title}</h5>
                  <p className="card-text small text-muted">{img.description}</p>
                </div>
                <div className="mt-2">
                  <span className="badge bg-info text-dark">{img.category}</span>
                </div>
              </div>
            </div>
          </div>
        ))
      ) : (
        <div className="text-center text-muted fs-5 mt-5">No images match your search or filter.</div>
      )}
    </div>
  );
}

export default ImageGrid;
