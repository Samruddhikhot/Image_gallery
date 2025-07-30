import React from 'react';

function BulkDeleteButton({ onDelete, disabled }) {
  return (
    <div className="text-end mb-3">
      <button
        className={`btn btn-${disabled ? 'secondary' : 'danger'} px-4 py-2 fw-semibold shadow`}
        onClick={onDelete}
        disabled={disabled}
      >
        🗑️ Delete Selected
      </button>
    </div>
  );
}

export default BulkDeleteButton;
