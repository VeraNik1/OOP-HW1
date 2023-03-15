public enum Relationship {
    parent {
        public Relationship getMirrorRel() {
            return child;
        }
    },
    child {
        public Relationship getMirrorRel() {
            return parent;
        }
    },
    partner {
        public Relationship getMirrorRel() {
            return partner;
        }
    };

    public abstract Relationship getMirrorRel();
    }

