const postCard = {
    props: ['post'],
    data: function() {
        return {
            postLink: "/post/" + this.post.slug
        }
    },
    template: `
    <a class="post-card-link" :href="postLink">
        <div class="post-card list-group-item list-group-item-action flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h3><a :href="postLink">{{ post.title }}</a></h3>
                <small class="text-muted">3 days ago</small>
            </div>
            <p class="text-muted">{{ post.content.substring(0, 210) + " . . . " }}</p>
            <small class="text-muted">{{ post.date }}</small>
        </div>
    </a>
    `
}

Vue.component("posts-loader", {
    components: {
        'post-card': postCard,
    },
    data: function() {
        return {
            posts: [],     
        }
    },
    template: `
    <div class="list-group">
        <post-card v-for="post in posts" :post="post" :key="post.id" />
    </div>
    `,
    created: function() {
        fetch('/api/posts')
            .then(response => response.json())
            .then(data => this.posts = data);
    }
})
